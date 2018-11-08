package com.gsyw.gfits.commons.service;

import java.util.Map;
import java.util.concurrent.Future;

public interface EmailTemplateService {

	Future<Boolean> sendEmailNotification(Map<String, Object> map);
}
