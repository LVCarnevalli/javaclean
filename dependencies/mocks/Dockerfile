FROM node:6.11-slim

WORKDIR /mocks
ADD *.yml /mocks/
ADD *.json /mocks/

ADD start.sh /mocks/start.sh
RUN chmod +x /mocks/start.sh

RUN npm install -g stubby

ENTRYPOINT ["./start.sh"]