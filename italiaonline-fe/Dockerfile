FROM node:18.19.1-alpine as build
WORKDIR '/app'
COPY package.json .
RUN npm install
COPY . .
EXPOSE 4200
CMD ["npm", "start"]