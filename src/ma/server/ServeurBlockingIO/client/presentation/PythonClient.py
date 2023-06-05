# echo-client.py

import socket

HOST = "127.0.0.1"  # The server's hostname or IP address
PORT = 4444  # The port used by the server

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))
    message = "Hello, server!"
    
    s.send(message.encode('utf-8'))
    data = s.recv(1024)

