package com.lips.web.api.portal.client;

import com.github.pagehelper.Page;
import com.lips.dao.lipsAdmin.pojo.SysUser;
import org.forkjoin.apikit.client.ApiType;
import org.forkjoin.apikit.client.ApiUtils;
import org.forkjoin.apikit.client.Callback;
import org.forkjoin.apikit.client.HttpClientAdapter;
import org.forkjoin.apikit.core.Result;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * Created by qiang on 2017/4/24.
 */
public class Test {
	private HttpClientAdapter httpClientAdapter;

	public Test(HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/test</b>
	 * <ul>
	 * <li><b>Model:</b> List&lt;SysUser&gt;</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see List&lt;SysUser&gt;

	 */
	public List<SysUser> homeData() {
		Result<List<SysUser>> result = home();
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			if (ex != null) {
				throw new RuntimeException(ex.getMessage(), ex);
			} else {
				throw new RuntimeException(result.toString());
			}
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/test</b>
	 * <ul>
	 * <li><b>Model:</b> List&lt;SysUser&gt;</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see List&lt;SysUser&gt;

	 */
	public Result<List<SysUser>> home() {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("/test", _uriVariables);

		return httpClientAdapter.request("GET", _url, null, _0Type, true);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/test</b>
	 * <ul>
	 * <li><b>Model:</b> List&lt;SysUser&gt;</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see List&lt;SysUser&gt;

	 */
	public Future<?> home(Callback<List<SysUser>> callable) {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("/test", _uriVariables);

		return httpClientAdapter.requestAsync("GET", _url, null, _0Type, true, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/testDate</b>
	 * <ul>
	 * <li><b>Form:</b>Datetest</li>
	 * <li><b>Model:</b> String</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see String
	 * @see Date

	 */
	public String testData() {
		Result<String> result = test();
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			if (ex != null) {
				throw new RuntimeException(ex.getMessage(), ex);
			} else {
				throw new RuntimeException(result.toString());
			}
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/testDate</b>
	 * <ul>
	 * <li><b>Form:</b>Datetest</li>
	 * <li><b>Model:</b> String</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see String
	 * @see Date

	 */
	public Result<String> test() {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("/testDate", _uriVariables);

		return httpClientAdapter.request("POST", _url, null, _1Type, true);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/testDate</b>
	 * <ul>
	 * <li><b>Form:</b>Datetest</li>
	 * <li><b>Model:</b> String</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see String
	 * @see Date

	 */
	public Future<?> test(Callback<String> callable) {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("/testDate", _uriVariables);

		return httpClientAdapter.requestAsync("POST", _url, null, _1Type, true, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/pageTest</b>
	 * <ul>
	 * <li><b>Model:</b> Page</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see Page

	 */
	public Page pageTestData() {
		Result<Page> result = pageTest();
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			if (ex != null) {
				throw new RuntimeException(ex.getMessage(), ex);
			} else {
				throw new RuntimeException(result.toString());
			}
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/pageTest</b>
	 * <ul>
	 * <li><b>Model:</b> Page</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see Page

	 */
	public Result<Page> pageTest() {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("/pageTest", _uriVariables);

		return httpClientAdapter.request("POST", _url, null, _2Type, true);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/pageTest</b>
	 * <ul>
	 * <li><b>Model:</b> Page</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see Page

	 */
	public Future<?> pageTest(Callback<Page> callable) {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("/pageTest", _uriVariables);

		return httpClientAdapter.requestAsync("POST", _url, null, _2Type, true, callable);
	}

	private static final ApiType _0Type = ApiUtils.type(Result.class,
			ApiUtils.type(List.class, ApiUtils.type(SysUser.class)));
	private static final ApiType _1Type = ApiUtils.type(Result.class, ApiUtils.type(String.class));
	private static final ApiType _2Type = ApiUtils.type(Result.class, ApiUtils.type(Page.class));
}