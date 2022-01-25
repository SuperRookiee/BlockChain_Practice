package util;

import java.security.MessageDigest;

public class Util {
	
	public static String getHash(String input) {	//� �Է°��� �������� Hash���� �����ִ� �Լ�
		StringBuffer result = new StringBuffer();	//���ڿ� �����ϴ� ��ü
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");	//��ȣȭ ������� MessageDigest�� ���� �̿�
			md.update(input.getBytes());								//����ڰ� �Է��ϴ� Byte���� �����ͼ� ������Ʈ (SHA-256�� �ؽý�Ű�� ���� �غ�)
			byte bytes[] = md.digest();									//�ؽ� ������� digest�Լ��� �̿��ؼ� byte��Ʈ������ �޾ƿ�
			for(int i=0; i<bytes.length; i++) {
				result.append(
						Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1)	//���ڿ� ���·� ��ȯ
				);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
}
