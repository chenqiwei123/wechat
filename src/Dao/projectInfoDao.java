package Dao;

import DataBase.ConnectDataBase;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class projectInfoDao {


    public static void main(String[] args) throws SQLException {
//        QueryProjectInfo("11",0);
        Map<String,String> map= new HashMap<>();
        map.put("p1_name","aa项目监管平台海昏侯古墓");
        map.put("p1_address","新建区大塘乡联合村大院自然村");
        map.put("p1_code","12342345");
        map.put("p1_time","20200331");
        map.put("p1_code2","234543");
        map.put("p1_number","2343223");
        map.put("p2_name","你好");
        map.put("p2_code","467");
        map.put("p2_tel","15180467670");
        map.put("p2_person","陈其巍");
        map.put("p2_phone","15179110117");
        map.put("p2_email","1049563035@qqq.com");
        map.put("p2_adress","新建区大塘乡联合村大院自然村");
        map.put("p3_file","http://www.runwsh.com/chen/upload/test");
        map.put("p3_info","我是备注");
        map.put("result","待审核");
        map.put("value","项目法人");
        map.put("openid","o1u0W1c7PFJPdfTCGMuC8bI0bxCg");
        System.out.println("result："+addProjectInfo(map));
    }

    public static int passProject(String id,String content) throws SQLException {
        String sql="UPDATE projectInfo SET result = '"+content+"' WHERE id = '"+id+"'";
        System.out.println("通过项目的sql："+sql);
        ConnectDataBase connectDataBase=new ConnectDataBase();
        Connection connection=connectDataBase.getConn();
        Statement ps=null;
        int aa=-1;
        try {
            ps=connection.createStatement();
            aa=ps.executeUpdate(sql);
            System.out.println("执行后插入项目申请的数据库执行官结果："+aa);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (connection!=null) connection.close();
        if(ps!=null) ps.close();
        return aa;
    }
    /**
     * 添加项目信息
     * @param map
     * @return
     * @throws SQLException
     */
    public static int addProjectInfo(Map<String, String> map) throws SQLException {
        PreparedStatement ps=null;
        Boolean result=false;
        int aa=-1;
        ResultSet rs=null;
        ConnectDataBase connectDataBase = new ConnectDataBase();
        Connection connection=connectDataBase.getConn();
        String sql="INSERT INTO projectInfo(`p1_name`, `p1_address`, `p1_code`, `p1_time`, `result`, `p1_code2`, `p1_number`, `p2_name`, `p2_code`, `p2_tel`, `p2_person`, `p2_phone`, `p2_email`, `p2_adress`, `p3_file`, `p3_info`,`openid`,`p1_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,map.get("p1_name"));
            ps.setString(2,map.get("p1_address"));
            ps.setString(3,map.get("p1_code"));
            ps.setString(4,map.get("p1_time"));
            ps.setString(5,map.get("result"));
            ps.setString(6,map.get("p1_code2"));
            ps.setString(7,map.get("p1_number"));
            ps.setString(8,map.get("p2_name"));
            ps.setString(9,map.get("p2_code"));
            ps.setString(10,map.get("p2_tel"));
            ps.setString(11,map.get("p2_person"));
            ps.setString(12,map.get("p2_phone"));
            ps.setString(13,map.get("p2_email"));
            ps.setString(14,map.get("p2_adress"));
            ps.setString(15,"我是文件");
            ps.setString(16,map.get("p3_info"));
            ps.setString(17, map.get("openid"));
            ps.setString(18,map.get("value"));
            aa=ps.executeUpdate();
            System.out.println("result:"+aa);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(connection,ps,rs);
        return aa;
    }

    /**
     * 关闭资源
     * @param connection
     * @param preparedStatement
     * @param resultSet
     * @throws SQLException
     */
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if (connection!=null);{
            connection.close();
        }
        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (resultSet!=null){
            resultSet.close();
        }
    }

    /**
     * 查询项目信息
     * @param openid
     * @return
     * @throws SQLException
     */
    public static String QueryProjectInfo(String openid,int LoginType) throws SQLException {
        int imagesId=0;
        String result = "";
        System.out.println("在获取项目信息的时候Dao:"+openid);
        ConnectDataBase connectDataBase=new ConnectDataBase();
        Connection connection=connectDataBase.getConn();
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        if (LoginType==1){
        String sql="select * from projectInfo where openid =?";
        ps=connection.prepareStatement(sql);
        ps.setString(1,openid);}
        else {
            String sql="select * from projectInfo where result='待审核'";
            ps=connection.prepareStatement(sql);
        }
        resultSet=ps.executeQuery();
        while (resultSet.next()){
            String id=resultSet.getString("id");
            String openid1=resultSet.getString("openid");
            String p1_name=resultSet.getString("p1_name");
            String p1_address=resultSet.getString("p1_address");
            String p1_code=resultSet.getString("p1_code");
            String p1_time=resultSet.getString("p1_time");
            String p1_code2=resultSet.getString("p1_code2");
            String p1_number=resultSet.getString("p1_number");
            String p2_name=resultSet.getString("p2_name");
            String p2_code=resultSet.getString("p2_code");
            String p2_tel=resultSet.getString("p2_tel");
            String p2_person=resultSet.getString("p2_person");
            String p2_phone=resultSet.getString("p2_phone");
            String p2_email=resultSet.getString("p2_email");
            String p2_adress=resultSet.getString("p2_adress");
            String p3_file=resultSet.getString("p3_file");
            String p3_info=resultSet.getString("p3_info");
            String p1_result=resultSet.getString("result");
            String p1_value=resultSet.getString("p1_value");
            String add="";
            System.out.println("ata-projectid"+id);
            System.out.println("data-openid"+openid);
            if (LoginType==0){
            add="<button type=\"button\" class=\"unpass\" style=\"margin:30px;\" data-openid=\""+openid1+"\" data-projectid=\""+id+"\">不通过审核</button><button type=\"button\" class=\"pass\" style=\"margin:30px;\" data-openid=\""+openid1+"\" data-projectid=\""+id+"\">通过审核</button>";}
            result=add+"<div class=\"ww\"><A class=\"aui-find-list aui-flex\" href=\"javascript:;\" id=\"partProjectInfo\">\n" +
                    "                        <DIV class=\"aui-find-img\">\n" +
                    "                            <IMG alt=\"\" src=\"homepage/images/"+imagesId%10+".jpg\">\n" +
                    "                        </DIV>\n" +
                    "                        <DIV class=\"aui-flex-box\">\n" +
                    "                            <H3>"+p1_name+"</H3>\n" +
                    "                            <P>"+p1_address+"</P>\n" +
                    "                        </DIV>\n" +
                    "                    </A>\n" +
                    "                    <table border=\"solid 1px gray\" style=\"display: none\" class=\"tables\">\n" +
                    "                        <tr>\n" +
                    "                            <td>项目名称</td>\n" +
                    "                            <td>"+p1_name+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>项目地址\t</td>\n" +
                    "                            <td>"+p1_address+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>建设性质</td>\n" +
                    "                            <td>"+p1_value+"</td>\n" +
                    "                        </tr><tr><td>项目状态</td><td>"+p1_result+"</td><tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>行业编码</td>\n" +
                    "                            <td>"+p1_code+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>建设时间</td>\n" +
                    "                            <td>"+p1_time+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>行政区划代码</td>\n" +
                    "                            <td>"+p1_code2+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>建设单位项目编号</td>\n" +
                    "                            <td>"+p1_number+"</td>\n" +
                    "                        </tr><tr><td style=\"width:400px;\">建设单位信息</td></tr>\n" +

                    "                        <tr>\n" +
                    "                            <td>单位名称</td>\n" +
                    "                            <td>"+p2_name+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>组织机构代码</td>\n" +
                    "                            <td>"+p2_code+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>单位联系电话</td>\n" +
                    "                            <td>"+p2_tel+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>项目联系人</td>\n" +
                    "                            <td>"+p2_person+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>项目联系人电话</td>\n" +
                    "                            <td>"+p2_phone+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>项目联系人电子邮箱</td>\n" +
                    "                            <td>"+p2_email+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>openid</td>\n" +
                    "                            <td>"+openid+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>单位地址</td>\n" +
                    "                            <td>"+p2_adress+"</td>\n" +
                    "                        </tr><tr><td style=\"width:400px;\">项目说明</td></tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>文件名称</td>\n" +
                    "                            <td>"+p3_file+"</td>\n" +
                    "                        </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td>备注</td>\n" +
                    "                            <td>"+p3_info+"</td>\n" +
                    "                        </tr></table></div>"+result;;
            imagesId=imagesId+1;


//            PojectInfo pojectInfo=new PojectInfo(p1_name,p1_address,p1_code,p1_time,p1_code2,p1_number,p2_name,p2_tel,p2_person,p2_phone,p2_email,p2_adress,p3_file,p3_info,p1_value);
//            list.add(pojectInfo);
        }
//        System.out.println(result);
        close(connection,ps,resultSet);
//        JSONObject jsonObject=JSONObject.fromObject(map1);
//        result=jsonObject.toString();
        return result;
    }
}
