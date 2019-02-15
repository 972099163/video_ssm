package com.travis.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.travis.entity.VideoInfomation;
import com.travis.result.ResultData;
import com.travis.service.VideoInfomationService;

@Controller
@RequestMapping("/videoInfomationController")
public class VideoInfomationController {
	@Autowired
	private VideoInfomationService videoInfomationService;
	public static Logger logger=Logger.getLogger(VideoInfomationController.class);
	
	@RequestMapping(value="/getVideo",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getVideo(String pageIndex)
	{
		if(null==pageIndex || "".equals(pageIndex))
		{
			return "页码不能为空";
		}
		String jsonString=null;
		Page page=PageHelper.startPage(Integer.parseInt(pageIndex),6);
	
		List<VideoInfomation>listVideoInfomation=videoInfomationService.selectAll(null);
	
		HashMap<String, Object> map=new HashMap();
		map.put("pageCount", page.getPages());
		map.put("current", pageIndex);
		map.put("listVideoInfomation", listVideoInfomation);
			ObjectMapper mapper=new ObjectMapper();
		try {
			
			jsonString=mapper.writeValueAsString(map);
			logger.info(jsonString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return jsonString;
	}
	
	@RequestMapping(value="/photoUpload",produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResultData<Object> PhotoUpload(MultipartFile file,HttpServletRequest request)
	{
		  ResultData<Object> resultData=new ResultData<Object>();
	        if (file!=null) {// �ж��ϴ����ļ��Ƿ�Ϊ��
	            String path=null;// �ļ�·��
	            String type=null;// �ļ�����
	            String fileName=file.getOriginalFilename();// �ļ�ԭ����
	            logger.info("�ϴ����ļ�ԭ����:"+fileName);
	            // �ж��ļ�����
	            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
	            if (type!=null) {// �ж��ļ������Ƿ�Ϊ��
	                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
	                    // ��Ŀ��������ʵ�ʷ������еĸ�·��
	                    String realPath=request.getSession().getServletContext().getRealPath("/");
	                    // �Զ�����ļ�����
	                    String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
	                    // ���ô��ͼƬ�ļ���·��
	                    path=realPath+/*System.getProperty("file.separator")+*/trueFileName;
	                    logger.info("���ͼƬ�ļ���·��:"+path);
	                    // ת���ļ���ָ����·��
	                    try {
							file.transferTo(new File(path));
						} catch (IllegalStateException e) {
							logger.error(e);
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							logger.error(e);
						}
	                    logger.info("�ļ��ɹ��ϴ���ָ��Ŀ¼��");
	                    resultData.setCode(200);
	                	  resultData.setMsg(path);
	                }else {
	                	  logger.info("����������Ҫ���ļ�����,�밴Ҫ�������ϴ�");
	                	  resultData.setCode(40001);
	                	  resultData.setMsg("����������Ҫ���ļ�����,�밴Ҫ�������ϴ�");
	                    return resultData;
	                }
	            }else {
	            	 
                	  resultData.setCode(40001);
                	  resultData.setMsg("�ļ�����Ϊ��");
                	  logger.info("�ļ�����Ϊ��");
	                return resultData;
	            }
	        }else {
	        	 resultData.setCode(40001);
           	  resultData.setMsg("û���ҵ���Ӧ���ļ�");
           	 logger.info("û���ҵ���Ӧ���ļ�");
	            return resultData;
	        }
	        return resultData;
	    }
	
	@RequestMapping(value="/video_add",produces = "application/json; charset=utf-8")
	public void VideoAdd(VideoInfomation videoInfomation )
	{
			System.out.println(videoInfomation);
	}
	@RequestMapping(value="/video_index",produces = "application/json; charset=utf-8")
	public String VideoIndex()
	{
		
		return "/video/video_index";
	}
	
	@RequestMapping(value="/video_add_page",produces = "application/json; charset=utf-8")
	public String VideoAddPage()
	{
		
		return "/video/video_add";
	}
}
