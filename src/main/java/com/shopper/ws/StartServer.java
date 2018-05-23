package com.shopper.ws;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.servlet.HashSessionManager;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.thread.QueuedThreadPool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  Embedded server using jetty
 */
public class StartServer {
    public static void main(String[] args) throws Exception {
        new StartServer().start();
    }

    private String warPath = "./src/main/webapp";

    private String contextPath = "/";

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private Server server;

    public synchronized Future<Server> start() {
        if (server != null) {
            throw new IllegalStateException(String.format("server already started (server = %s)", server));
        }
        return executorService.submit(new Callable<Server>() {
            @Override
            public Server call() throws Exception {

                server = new Server();
                QueuedThreadPool threadPool = new QueuedThreadPool();
                threadPool.setMaxThreads(10);
                threadPool.setName("Jetty thread");
                server.setThreadPool(threadPool);

                SelectChannelConnector connector = new SelectChannelConnector();
                connector.setPort(8080);
                server.addConnector(connector);
                server.setStopAtShutdown(true);

                WebAppContext ctx = new WebAppContext();

                HashSessionManager sessManager = new HashSessionManager();
                sessManager.setSessionCookie(System.getProperty("jetty.SessionCookie", "spyum"));
//                sessManager.setSessionURL(System.getProperty("jetty.SessionURL", "tspsurl"));
                sessManager.setSessionPath(System.getProperty("jetty.SessionPath", "/"));
                ctx.getSessionHandler().setSessionManager(sessManager);
                ctx.setContextPath(contextPath);
                ctx.setWar(warPath);
                server.addHandler(ctx);
                addStopHandler(server);
                server.setStopAtShutdown(true);
                server.start();
                return server;
            }
        });
    }

    /**
     * invoke the following to shut down the server:
     * http://localhost:8080/stop
     *
     * @param server
     */
    private void addStopHandler(final Server server) {
        server.addHandler(new AbstractHandler() {
            public void handle(String target, HttpServletRequest req, HttpServletResponse arg2, int arg3)
                    throws IOException, ServletException {

                if (target.startsWith("/stop")) {
                    try {
						server.stop();
	                    server.join();
					}
                    catch (Exception e) {
						e.printStackTrace();
					}
                    System.exit(1);
                }
            }
        });
    }

}
