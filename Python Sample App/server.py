#!/usr/bin/env python3
from http.server import BaseHTTPRequestHandler, HTTPServer
import os, datetime

class myServer(BaseHTTPRequestHandler):
    def do_GET(self):
        load = os.getloadavg()
        now = datetime.datetime.now().astimezone()
        html = f"""<!DOCTYPE html>
<html>
    <head>
        <title>Hello world</title>
        <meta charset="utf-8" />
    </head>
    <body>
        <h1>Hello world: python</h1>
        Server time: {now}<br />
        Server utilization (load): {load[0]}
    </body>
</html>"""
        self.send_response(200)
        self.send_header('Content-type','text/html')
        self.end_headers()
        self.wfile.write(bytes(html, "utf8"))

def run():
    addr = ('', 8080)
    httpd = HTTPServer(addr, myServer)
    print('Starting server...')
    httpd.serve_forever()

if __name__ == '__main__':
    run()
