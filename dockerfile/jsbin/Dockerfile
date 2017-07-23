FROM node:boron

RUN  apt-get update && DEBIAN_FRONTEND=noninteractive apt-get install -yq --no-install-recommends \
        apt-utils \
        libpcre3-dev \
        build-essential \
        libssl-dev \
        mysql-server

RUN cd /opt && git clone https://github.com/jsbin/jsbin.git
RUN cd /opt/jsbin && yarn install && yarn build

# start mysql and load sql file
RUN /etc/init.d/mysql start && \
    mysql -uroot -e 'create database jsbin' && \
    mysql -uroot jsbin < /opt/jsbin/build/full-db-v3.mysql.sql

# override
COPY config.default.json /opt/jsbin/config.default.json
#
EXPOSE 3000
WORKDIR /opt/jsbin

#CMD ["yarn", "start"]

# for test
# docker run -it --rm -p 3000:3000 wefine/jsbin bash

