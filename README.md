# PeertoPeer

# Overview
This project demonstrates a basic peer-to-peer (P2P) communication system in Java using TCP sockets and AES encryption. It allows two users to securely exchange messages over the network.

# How It Works
# Receiver (Server)
Listens on a fixed port (default: 5000)

Accepts incoming socket connections

Reads the encrypted message, decrypts it using AES

Displays the decrypted message in the console

# Sender (Client)
Accepts user input from console

Encrypts the message using AES

Sends it to the specified IP address and port

Also listens for incoming messages (works like a peer)

Both Sender and Receiver can act as peers, sending and receiving messages simultaneously.

# Encryption Details
Algorithm: AES (Advanced Encryption Standard)

Key: 1234567812345678 (128-bit, hardcoded)

Encrypted message is Base64 encoded before transmission

Decryption is performed on the receiving side using the same key

# Features
 Two-way communication between peers

 Secure message transmission using AES

 Minimal & educational, ideal for learning Java sockets and cryptography

# Limitations
 No GUI (text-based only)

 Secret key is hardcoded (not safe for real-world use)

 No message history/logs

 No support for multiple simultaneous clients

 Requires both peers to be on the same network (or open ports for public IP)
