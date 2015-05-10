package day04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestHashMap
{
	/**
	 * ͳ�Ƹ�������������PM2.5�����ֵ
	 * 
	 */
	
	@Test
	public void test1(){
		String pm25 = "ũչ��=423,����=378,��̨��԰=406,��̳=322,����������=398,"
				+ "��Ա= 408,ͨ��=366,��ƽ��=248,������=306,����=231,ǰ��=422,"
				+ "���ֵ�=356,�ų�=268,��ƽ��=267,������=306,����=231,ǰ��=422,"
				+ "ũչ��=423,����=378,��̨��԰=406,��̳=322,����������=398,";
		
		
		
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		String[] arr = pm25.split("[,=]");
		   //ȡ����վ������PM2.5�����ֵ
			for(int i = 0; i < arr.length; i+=2){//ÿ��������һ������
				if(!map.containsKey(arr[i])
						||Integer.parseInt(arr[i+1]) > map.get(arr[i])){
					map.put(arr[i], Integer.parseInt(arr[i+1]));
				}
			}
			System.out.println(map);
				
			
			Set<String> keys = map.keySet();
			for(String key: keys){
				System.out.println(key + ":" + map.get(key));
			}
		}
	}
	


