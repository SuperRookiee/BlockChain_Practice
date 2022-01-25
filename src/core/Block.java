package core;

import java.util.ArrayList;

import util.Util;

public class Block {

	private int blockId;
	private String previousBlockHash;
	private int nonce;
//	private String data;
	private ArrayList<Transaction> transactionList;	//��� Ʈ������� ��� ArrayList ����
	
	
	//���� ����� Hashȭ
	//Ʈ������� ������ �ٲ�ٸ� Hash�� ��ü�� ���� ��
	//Ư���� ����� Hash���� ���� ��, �ش��Ͽ� ���ԵǾ��ִ� ��� Ʈ������� �����ϵ��� ����
	public String getBlockHash() {
		String transactionInformations = "";
		for(int i=0; i<transactionList.size(); i++) {
			transactionInformations += transactionList.get(i).getInformation();
		}
		return Util.getHash(nonce + transactionInformations + previousBlockHash);
	}
	
	
	//���ο� Ʈ������� �߻����� �� �� Ʈ������� �ش� ��Ͽ� �ִ� �Լ� 
	public void addTransaction(Transaction transaction) {	
		transactionList.add(transaction);
	}
	
	//ä���� ����
	public void mine() {
		while(true) {
			if(getBlockHash().substring(0, 4).equals("0000")) {	//�տ������� 0�� 4�ڸ��̸� ä���� �����ߴٰ� �Ǵ�
				System.out.println(blockId + "��° ����� ä���� �����߽��ϴ�.");
				break;
			}
			nonce++; //ä���� ���� �ߴٸ� nonce�� +1
		}
	}
	
	//���
	public void getInformation() {
		System.out.println("--------------------------------------");
		System.out.println("��� ��ȣ: " + getBlockId());
		System.out.println("���� �ؽ�: " + getPreviousBlockHash());
		System.out.println("ä�� ���� ��: " + getNonce());
		System.out.println("Ʈ����� ����: " + transactionList.size() + "��");
		for(int i=0; i<transactionList.size(); i++) {
			System.out.println(transactionList.get(i).getInformation());
		}
		System.out.println("��� �ؽ�: " + getBlockHash());
		System.out.println("--------------------------------------");

	}
	
	
	
	//������
	public Block(int blockId, String previousBlockHash, int nonce, ArrayList transactionList) {
		super();
		this.blockId = blockId;
		this.previousBlockHash = previousBlockHash;
		this.nonce = nonce;
		this.transactionList = transactionList;
	}
	
	//Getter & Setter
	public int getBlockId() {
		return blockId;
	}
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}
	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}

	
}
