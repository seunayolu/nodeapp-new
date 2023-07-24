# File: hello-world-node/Dockerfile (docbuc/hello-world-node)
FROM node:16
ENV TZ="Europe/Amsterdam"
COPY server.js /src/
USER node
CMD ["node", "/src/server.js"]