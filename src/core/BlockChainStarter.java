package core;

import java.util.ArrayList;
import java.util.Scanner;

import util.Util;

public class BlockChainStarter {	//���ü���� ���������� �����ϴ� �����Լ��� ���ԵǾ��ִ� �Լ�

	public static void main(String[] args) {
//		one();
//		two();
//		three();
//		four();
		five();
		
	}//main ends
	
	
	public static void one() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Key �Է� : ");
		System.out.println(Util.getHash( sc.next() ));	//Util��Ű���� getHash�Լ� ����
	}
	
	
	public static void two() {
		int nonce = 0;
		while(true) {
			if(Util.getHash(nonce + "").substring(0,6).equals("000000")) {	//���� �����ڸ��� ��� 0�� ����� �� == (1/2^24) == õ���� �̻�
				System.out.println("����: " + nonce);
				System.out.println("�ؽ� ��: " + Util.getHash(nonce + ""));
				break;
			}
			nonce++;
		}
	}
	
	
	public static void three() {
		
		// data -> Transaction
		
//		Block block1 = new Block (1, null, 0, "������");					//��� ��ȣ:1 , nonce:0
//		block1.mine();
//		block1.getInformation();
//		
//		Block block2 = new Block (2, block1.getBlockHash(), 0, "������");	//��� ��ȣ:2 , nonce:0
//		block2.mine();
//		block2.getInformation();
//		
//		Block block3 = new Block (3, block2.getBlockHash(), 0, "������");	//��� ��ȣ:3 , nonce:0
//		block3.mine();
//		block3.getInformation();
//
//		Block block4 = new Block (4, block3.getBlockHash(), 0, "������");	//��� ��ȣ:4 , nonce:0
//		block4.mine();
//		block4.getInformation();
	}
	
	
	public static void four() {
		Transaction transaction = new Transaction("������", "�����", 1.5);
		System.out.println(transaction.getInformation());
	}
	
	
	public static void five() {
		Block block1 = new Block (1, null, 0, new ArrayList());
		block1.mine();
		block1.getInformation();
		
		Block block2 = new Block (2, block1.getBlockHash(), 0, new ArrayList());
		block2.addTransaction(new Transaction("������", "�����", 1.5));
		block2.addTransaction(new Transaction("��ũ�ִ�", "�����", 0.7));
		block2.mine();
		block2.getInformation();
		
		Block block3 = new Block (3, block2.getBlockHash(), 0, new ArrayList());
		block3.addTransaction(new Transaction("�ּ���", "����ȣ", 8.2));
		block3.addTransaction(new Transaction("�����", "������", 0.4));
//		block3.addTransaction(new Transaction("�����", "������", 9.9));	//�������� ��Ŀ�� �������� �� block3������ Hash���� �ٲ�
		block3.mine();
		block3.getInformation();
		
		Block block4 = new Block (4, block3.getBlockHash(), 0, new ArrayList());
		block4.addTransaction(new Transaction("����ȣ", "�ּ���", 0.1));
		block4.mine();
		block4.getInformation();
		
	}
}
