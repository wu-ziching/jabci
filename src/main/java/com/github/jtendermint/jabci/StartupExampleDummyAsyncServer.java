/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2016 - 2017
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.github.jtendermint.jabci;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jtendermint.jabci.socket.async.AsyncServer;

public class StartupExampleDummyAsyncServer {
    private final static Logger LOG = LoggerFactory.getLogger(StartupExampleDummyAsyncServer.class);

    public static void main(String[] args) throws InterruptedException, IOException {
        new StartupExampleDummyAsyncServer().startExampleDummy();
    }

    public void startExampleDummy() throws InterruptedException, IOException {
        LOG.info("Starting Example Dummy");

        final AsyncServer sock = new AsyncServer();

        //// register ABCI-API listeners here:
        //// listeners can be ABCIAPI for accepting all messages or
        //// single interfaces like IInfo, IDeliverTX, etc... to only target specific cases
        // sock.registerListener(some_listeners);
        
        new Thread(sock::start).start();

        while (true) {
            Thread.sleep(1000L);
        }
    }

}
