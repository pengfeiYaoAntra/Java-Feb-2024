package com.training.demo;

public class Day6 {
    /*
     networking:
     TCP
     UDP
     DNS
     HTTPS
        status code
        methods

      singleton
      factor


      OSI model: 7 layers
      1: application layer: the most top layer that allows end-users to interact with

      2: presentation layer: this layer transforms the data into the form that application layer wants to accepts
                            the main functions of this layer: data decryption, encryption, translation, formatting
       3: Session layer:
                this layer manages and controls the connections between devices: it maintenance, terminates, establishes, coordinates
                the connections
       4: transport layer:
              you have acknowledgment of successful data transmission between nodes
              what is node? ->any devices connected to a network
        5:network layer:
                this layer transfers variable len data sequence from one node to another node
                datagrams is variable len data
         6: data link layer: logical link, mac layer -> error control, flow control
            data packets are encoded and decoded into bits
         7: physical layer. it converts data bits into electrical impulses or radio signals

       TCP/IP model: four layers: http, FTP, SMTP...
        Application layer: interfaces for application to access network service
        transport layer: end-to-end communication and data transfer management between two hosts
        network layer / internet layer: layer sends data across network and should include: source/ destination ip addrress
        network access layer: it transfers data packets between different hosts. it encapsulates IP packets, mapping ip address to physical hardware



        TCP
        SYN: used to establish connection between client and server
        ACK: let one side(client, server) knows other side that it has received the SYN
        FIN: to terminate the connection between client and server
        SYN-ACK: SYN message from local device and ACK of earlier packet
        SEQ: keep tracking how many data it has sent


        three ways handshake
        client state            client              server              server state

step1      LISTEN                SYN =1 Seq =x ->                          LISTEN
               |
 step2    SYN SENT                           <- SYN =1, Seq = y, ACK=x+1     SYN RCVD
                |                                                               |
step 3      ESTAB                 ACKnum=y+1 ->                             ESTAB
                why three times -> prevents old duplicate connection and connection confusion
                if the first step is lost, client side will resend everything
                if  the second step is lost, client side restart from step and sent everything, server side will send everything


connection terminate

step1       ESTAB               FINbit =1 seq =x ->                     ESTAB
            FIN-WAIT-1                                                  CLOSE_WAIT
step2                                                   <- ACK = X+1

                            still allow server to send data between step 2 and step 3
             FIN-WAIT-2
step 3                                               <- FIN =1, seq =y     LAST_ACK

            TIMED_WAIT          ->ack                                       CLOSED

                CLOSED




      UDP
      there is not connection ESTAB
       it sends packets DIRECTLY to a target computer without establishing a connection
       steps:
            data is prepared:
            Datagram is sent:
            Datagram is received: the server received the data
            Data is extracted

       DNS -> www.google.com -> 123.123.123.123
       www.     google                  .com
                |                         |
               second level         Top level

        1: user enters domain name: www.google.com
        2:chrome will check caching if you have id address, you access, if not you need send a query to dns server like internet provider: ATT, Tmobile, xfinity
        3: if not cached query sent to root server, check TLD(top level domain -> such as .com, .edu, .org)
        4: check SLD(second level domain -> google, X,) -> return ip
        5: receive ip


        HTTP
        four:
        stateless protocol: stateless: each request sent from a client to a server is treated independently
        methods: GET, POST, DELETE, HEAD, PUT
        header: metadata about the message: content type, content, len, server information, caching polices
        status code: 1XX -> informational, 2XX-> success, 3XX->redirection, 4XX-> client error, 5XX->server error

        HTTP request message body
           Method  path   version of the protocol   header
           GET   /getCar       HTTP/1.1                 content type, content, len, server information, caching polices
        HTTP Response Message body
            version of the protocol     status code      status message     header
            HTTP/1.1                        200             ok          content type, content, len, server information, caching polices

         Methods:
         GET
                retrieves data from server side
         HEAD
                similar to get, but it retrieves only the header of a resource(server)
                used for gathering meta-information

         POST
            sends data to CREATE or UPDATE a resource
            often used when submitting form data or uploading a file

         PUT
            REPLACE all current target resource
            can create a resource if the resource does not exist

         DELETE
                delete or remove the specified resource
         CONNECTION
                establishes a connection(tunnel) to server
          OPTIONS
            used to describe the communication(connection) options for the target resource


            status code:
            1XX: informational
                    server side requires the client side to take action to continue the process
                    100: the server has received the request headers, the client side should proceed to send the request body

             2XX: success
                    the client request was successfully received
                     200: ok:
                     201: created
                     204: no content: the server successfully processed the request without returning any content
              3XX
                    further action needs to be taken to complete the request
                    301: URL that you request has been changed

                    302: for redirecting the client to another URL
                    304: not modified the resource has not been modified since the last request
              4XX: client error
                400: bad request
                404 not found

              5XX server error
                500: internal server error
                504: gateway timeout




        HTTPS:http + ssl/tls = htttps
        Symmetric algorithm:
            use the same key for encryption and decryption on server and client side

        Asymmetric algorithm
            use the public key for encryption and private key for decryption.

        steps of https connection:
            1:client initiates connection: https://www.google.com -> you as a client to send a request to the server using https

            2:server received your request and sends its certificate
                    the server will respond by sending ssl/tls certificate to the client.
                    this certificate includes public key and CA(certificate authority)
            3:certificate verification on the client side:
                    the client side will ask: is the certificate signed by a trusted CA?
                                                is the certificate not expired?
                                                is the domain name on the certificate matches with the domain name that client asked

            4:Client side will generate a pre-master key
                pre master key for encrypting the session key (used this session key is used for encryption data)

            5: secure key exchange:
                    client will send encrypted pre-master key with public key to the server side
                    the server will decrypt this by using private key
             6: session key creation
                    both the client and server use some algorithm with pre-master key to generate the same session keys
              7: client and server side both ready
              8: data transfer
                data is encrypted with session key -> symmetric algorithm



         ...
     */
    public static void main(String[] args) {
        // prototype demo
        Prototype prototypeOriginal = new Prototype("Matthew",18);
        System.out.println(prototypeOriginal.getAge() + " " + prototypeOriginal.getName());

        try {
            Prototype copied = (Prototype) prototypeOriginal.clone();
            copied.setName("PEngfei");
            System.out.println(copied.getName());

        }catch ( CloneNotSupportedException e){
            e.getMessage();
        }

    }

    /*
        design patten: what is singleton pattern, what design pattern you used for your project what prototype pattern what is factory pattern

        singleton pattern

            when your class is loaded, singleton instance is created
            eager initialization:
                    dis: creating the instance even you do not need
            static block initialization

            when you need singleton instance
            lazy initialization
            thread safe

            bill pugh


            prototype pattern: coping an existing object-> shallow copy by default, you also can do deep copy
                        shallow: primitive type; copy the value
                        reference type: copy the value of reference
                        deep copy: create a new same object


            Factory



     */
    //eager initialization:

}
