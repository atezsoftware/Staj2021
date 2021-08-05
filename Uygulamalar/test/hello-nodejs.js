const http = require('http');

const hostname = '127.0.0.1';
const port = 3000;

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  console.log(req.method, req.url, new Date().toISOString());
  let url = req.url;
  if (url.indexOf('?') > -1) {
    let [urlPart, query] = url.split('?');
    query.split('&').forEach((f) => {
      console.log(f.split('='));
    });
  }
  res.end('Hello World');
});

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});
