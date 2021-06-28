package jp.co.internous.wasabi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.wasabi.model.domain.MstDestination;
import jp.co.internous.wasabi.model.domain.MstUser;
import jp.co.internous.wasabi.model.form.DestinationForm;
import jp.co.internous.wasabi.model.mapper.MstDestinationMapper;
import jp.co.internous.wasabi.model.mapper.MstUserMapper;
import jp.co.internous.wasabi.model.session.LoginSession;

@Controller
@RequestMapping("/wasabi/destination")
public class DestinationController {
	@Autowired
	private MstUserMapper mstUserMapper;
	
	@Autowired
	private MstDestinationMapper mstDestinationMapper;
	
	@Autowired
	LoginSession loginSession;
	
	private Gson gson = new Gson();
		
	@RequestMapping("/")
	public String index(Model m) {
		MstUser user = mstUserMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		
		m.addAttribute("user", user);
		
		m.addAttribute("loginSession",  loginSession);
		return "destination";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean delete(@RequestBody String destinationId) {
		
		Map<String, String> map = gson.fromJson(destinationId, Map.class);
		String id = map.get("destinationId");
		
		int result = mstDestinationMapper.logicalDeleteById(Integer.parseInt(id));
		
		return result > 0;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(@RequestBody DestinationForm f) {
		// 宛先を登録
		MstDestination destination = new MstDestination(f);
		int userId = loginSession.getUserId();
		destination.setUserId(userId);
		int count = mstDestinationMapper.insert(destination);
		
		// 登録した宛先のIDを取得
		Integer id = 0;
		if (count > 0) {
			id = destination.getId();
		}
		return id.toString();
	}
	
}
