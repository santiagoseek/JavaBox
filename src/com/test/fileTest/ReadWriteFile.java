package com.test.fileTest;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWriteFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// readStringAndDisplay();
		// savegifFile();

		// writeDataToFile();
		// readDataFromFile();
		
		readNumAndCalc();
	}

	// ����һ���ļ����Ӽ��������ַ�������������ʱ����������Ļ����ʾ���ļ�����������
	public static void readStringAndDisplay() {
		char ch;
		int data;
		try {
			FileInputStream in = new FileInputStream(FileDescriptor.in);
			FileOutputStream out = new FileOutputStream("ThisIsTestFile");
			System.out.println("Please input the string, end with #:");
			while ((ch = (char) in.read()) != '#') {
				out.write(ch);
			}
			in.close();
			out.close();
			System.out.println();
			FileInputStream newIn = new FileInputStream("ThisIsTestFile");
			FileOutputStream newOut = new FileOutputStream(FileDescriptor.out);
			while (newIn.available() > 0) {
				data = newIn.read();
				newOut.write(data);
			}
			newIn.close();
			newOut.close();
		} catch (FileNotFoundException e) {
			System.out.println("Not found the file.");
		} catch (IOException e) {
		}
	}

	// ʵ�ֶԶ�����ͼ���ļ�(.gif)�ı���
	public static void savegifFile() {
		FileInputStream in;
		try {
			in = new FileInputStream("test.gif");
			FileOutputStream out = new FileOutputStream("test_copy.gif");
			System.out.println("this file size is:" + in.available());
			byte c[] = new byte[in.available()];
			in.read(c);
			out.write(c);
			System.out.println("file has copyed!");
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		}
	}

	// д�����ݵ��ļ�
	public static void writeDataToFile() {
		String dataFile = "DataFile.dat";
		int value1 = 100, value2 = 0, value3 = -104;
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(
					dataFile));
			out.writeInt(value1);
			out.writeInt(value2);
			out.writeInt(value3);
			out.close();
		} catch (IOException i) {
			System.out.println("Error !" + dataFile);
		}
	}

	// ���ļ��������ݲ������
	public static void readDataFromFile() {
		String dataFile = "DataFile.dat";
		int sum = 0;
		DataInputStream in = null;
		try {
			in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(dataFile)));
			while (true) {
				sum += in.readInt();
			}
		} catch (EOFException e) {
			System.out.println("Sum is: " + sum);
			try {
				in.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException i) {
			System.out.println("Error !" + dataFile);
		}
	}

	// �Ӽ�������һ����������������ĸ�����֮��
	public static void readNumAndCalc() {
		DataInputStream in = new DataInputStream(System.in);
		System.out.println("please input the Integer: ");
		int num;
		try {
			num = in.readInt();
			int sum = 0;
			int temp = num;
			while (temp > 0) {
				int data = temp % 10;
				temp = temp / 10;
				sum = sum + data;
			}
			//System.out.println(num);
			System.out.println(num + "the number sum is:" + sum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
