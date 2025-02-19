# Real-Time Chat Application

This project is a real-time chat application built using JavaFX and Socket Programming. It features a simple and responsive UI for sending and receiving messages in real-time between a server and a client.

## How to Run

To run the application, follow these steps:

1. **Run the Server Application:**
   - Navigate to the `messenger-server` directory.
   - Run the `Main` file in the `Server` project to start the server.

2. **Run the Client Application:**
   - After the server is running, navigate to the `messenger-client` directory.
   - Run the `Main` file in the `Client` project to start the client.

Both applications should run on separate instances. The client will send messages to the server, and the server will relay those messages to the connected clients.

## Project Structure

- **messenger-client/**: The client-side application where users can send and receive messages.
- **messenger-server/**: The server-side application that handles incoming messages and broadcasts them to clients.

## Features

- Real-time message sending and receiving.
- Basic UI layout using JavaFX.
- Simple server-client communication using socket programming.

## Future Improvements

This application can be expanded with the following features:
- Encryption for secure messaging.
- Group chat support.
- Message history storage (e.g., using a database).

## Technologies Used

- Java
- JavaFX
- Socket Programming
