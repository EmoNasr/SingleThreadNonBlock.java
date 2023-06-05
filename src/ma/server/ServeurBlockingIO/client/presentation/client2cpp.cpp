#include <boost/asio.hpp>
#include <iostream>

int main()
{
    boost::asio::io_context io_context;
    boost::asio::ip::tcp::socket socket(io_context);

    boost::asio::ip::tcp::resolver resolver(io_context);
    boost::asio::ip::tcp::resolver::results_type endpoints =
        resolver.resolve("localhost", "1234"); // replace with your server's address and port

    boost::asio::connect(socket, endpoints);

    // send data
    std::string message = "Hello, server!";
    boost::asio::write(socket, boost::asio::buffer(message));

    // receive data
    boost::asio::streambuf response;
    boost::asio::read_until(socket, response, "\n");
    std::string received_message = boost::asio::buffer_cast<const char*>(response.data());

    std::cout << "Received message: " << received_message << std::endl;

    return 0;
}
