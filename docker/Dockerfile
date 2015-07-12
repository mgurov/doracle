FROM wnameless/oracle-xe-11g

ADD bootstrap.sql /sql/bootstrap.sql

RUN bash -i -c 'service oracle-xe start &&\
 sqlplus system/oracle @/sql/bootstrap.sql &&\
  service oracle-xe stop &&\
  rm /sql/bootstrap.sql'