// File hello-world-node/server.js
const http = require("http");
const os = require("os");

http.createServer((req, res) => {
  const dateTime = new Date();
  const load = os.loadavg();
  const doc = `<!DOCTYPE html>
<html>
<head>
<title>Hello world</title>
<meta charset="utf-8" />
</head>
<body>
<h1>Hello world: node</h1>
Server time: ${dateTime}<br />
Server utilization (load): ${load[0]}
</body>
</html>`;
  res.setHeader('Content-Type', 'text/html');
  res.end(doc);
}).listen(8080, () => {
  console.log('Server is running on port 8080');
});
