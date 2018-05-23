#!/bin/bash
if [ $# -ne 2 ] 
then
  echo "Script takes 2 arguments as input"
  echo "Usage:'$0' <start_date> <end_date>"
  exit 1
fi
sqlite3 applicants.sqlite3 "SELECT count(*),max(date(created_at, 'weekday 1', '-7 day')), workflow_state  FROM applicants where created_at > '$1' and created_at < '$2' group by strftime('%W',created_at),workflow_state having count(*) > 0;" > output.csv
