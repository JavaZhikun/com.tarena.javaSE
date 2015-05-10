package day04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestHashMap
{
	/**
	 * 统计各空气质量监测点PM2.5的最高值
	 * 
	 */
	
	@Test
	public void test1(){
		String pm25 = "农展馆=423,东四=378,丰台花园=406,天坛=322,海淀区万柳=398,"
				+ "官员= 408,通州=366,昌平镇=248,怀柔镇=306,定陵=231,前门=422,"
				+ "永乐店=356,古城=268,昌平镇=267,怀柔镇=306,定陵=231,前门=422,"
				+ "农展馆=423,东四=378,丰台花园=406,天坛=322,海淀区万柳=398,";
		
		
		
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		String[] arr = pm25.split("[,=]");
		   //取各个站点名的PM2.5的最大值
			for(int i = 0; i < arr.length; i+=2){//每隔两个是一个数字
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
	


