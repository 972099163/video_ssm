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
			return "椤电爜涓嶈兘涓虹┖";
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
	        if (file!=null) {// 判断上传的文件是否为空
	            String path=null;// 文件路径
	            String type=null;// 文件类型
	            String fileName=file.getOriginalFilename();// 文件原名称
	            logger.info("上传的文件原名称:"+fileName);
	            // 判断文件类型
	            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
	            if (type!=null) {// 判断文件类型是否为空
	                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
	                    // 项目在容器中实际发布运行的根路径
	                    String realPath=request.getSession().getServletContext().getRealPath("/");
	                    // 自定义的文件名称
	                    String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
	                    // 设置存放图片文件的路径
	                    path=realPath+/*System.getProperty("file.separator")+*/trueFileName;
	                    logger.info("存放图片文件的路径:"+path);
	                    // 转存文件到指定的路径
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
	                    logger.info("文件成功上传到指定目录下");
	                    resultData.setCode(200);
	                	  resultData.setMsg(path);
	                }else {
	                	  logger.info("不是我们想要的文件类型,请按要求重新上传");
	                	  resultData.setCode(40001);
	                	  resultData.setMsg("不是我们想要的文件类型,请按要求重新上传");
	                    return resultData;
	                }
	            }else {
	            	 
                	  resultData.setCode(40001);
                	  resultData.setMsg("文件类型为空");
                	  logger.info("文件类型为空");
	                return resultData;
	            }
	        }else {
	        	 resultData.setCode(40001);
           	  resultData.setMsg("没有找到对应的文件");
           	 logger.info("没有找到对应的文件");
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
