package jsondemos.sfjson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2018-12-04 15:06
 **/
public class Demo {

    public static final String objJsonStr = "{\"networkRateType\":150," +
            "\"diskList\":[{\"diskMediaType\":\"普通云盘\",\"diskName\":\"\",\"diskSize\":6,\"storeName\":\"\",\"diskType\":1}]," +
            "\"memory\":2,\"bandwidth\":10,\"namePrefix\":\"root\",\"count\":1,\"cpu\":1," +
            "\"location\":{\"cluster\":\"cluster01\",\"datastoreUrn\":\"\",\"resourceId\":\"171c4e6c-eb0d-4a33-a5f8-ee525e129b8a\",\"vmName\":\"\",\"datastore\":\"\",\"datacenterId\":\"datacenter-2\",\"hostId\":\"422bacf0-f13f-b09f-6d2b-c29b601b563b\",\"datacenter\":\"桌面\",\"resourceName\":\"172.16.150.43\",\"clusterId\":\"domain-c7\",\"osName\":\"Windows xp sp3 32位 专业版\",\"type\":\"Vmware\",\"datastoreUri\":\"\",\"siteUri\":\"\",\"endpoint\":\"\",\"hostUrn\":\"\",\"host\":\"172.16.150.41\",\"hostUri\":\"\",\"vmwareResource\":null},\"osName\":\"Windows xp sp3 32位 专业版\",\"networkSize\":1}";

    private static String arrJsonStr = "[{\"name\":\"dada\",\"age\":\"44\"},{\"name\":\"xiaoxiao\",\"age\":\"55\"}]";

    public static void main(String[] args) {
        readFromString();
    }

    /**
     * 从json字符串中读取数据
     */
    private static void readFromString() {
        JSONObject jsonObject = JSONObject.fromObject(objJsonStr);

        //jsonObject只能转换以{ 开头的字符串
        //JSONObject jsonArr = JSONObject.fromObject(arrJsonStr);
        JSONArray jsonArray = JSONArray.fromObject(arrJsonStr);
        System.out.println("debug");

    }
}
