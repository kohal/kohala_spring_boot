package com.reflex.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: xuyongjian
 * @date: 2017/11/22
 */
public class TxtFileReader {

    public static void main(String[] args) throws FileNotFoundException {
        int bufSize = 10000;
        File file = new File("/Users/xuyongjian/CH1955BST.txt");

        FileChannel fileChannel = new RandomAccessFile(file, "r").getChannel();

        ByteBuffer rBuffer = ByteBuffer.allocate(bufSize);

        StringBuffer strBuf = new StringBuffer("");
        System.out.println(file.toString());

    }
}
