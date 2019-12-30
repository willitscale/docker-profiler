FROM ubuntu:latest

RUN apt-get update
RUN apt-get install socat -yy

CMD ["socat", "tcp-listen:10056", "SYSTEM:'docker stats --all'"]
