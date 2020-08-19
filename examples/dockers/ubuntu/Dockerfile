FROM ubuntu:18.04

MAINTAINER "Storm IT Tomasz Woliński"

RUN yes | unminimize

RUN set -xe \
    && apt-get update \
    && apt-get install -y vim less tree nano psmisc openssh-client iputils-ping zip unzip tar man


CMD [ "/bin/bash" ]
