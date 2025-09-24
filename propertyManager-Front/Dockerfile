FROM node:22-alpine

WORKDIR /usrapp/bin

ENV PORT=35000
EXPOSE 35000

COPY . . 
RUN npm install -g http-server

CMD ["http-server", "-p", "35000", "-c-1"]