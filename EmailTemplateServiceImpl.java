package com.gsyw.gfits.commons.service.impl;

import java.util.Map;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.gsyw.gfits.commons.repository.EmailTemplateRepository;
import com.gsyw.gfits.commons.service.EmailTemplateService;
import com.gsyw.gfits.commons.util.EmailTemplateConstant;
import com.gsyw.gfits.commons.util.MailTemplateContentBuilder;
import com.gsyw.gfits.domain.EmailTemplate;
import com.gsyw.gfits.domain.SignUpRequest;
import com.gsyw.gfits.user.repository.UserRepository;

@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MailTemplateContentBuilder mailContentBuilder;

	@Autowired
	private EmailTemplateRepository emailTemplateRepository;

	@Autowired
	private UserRepository userRepository;

	@Value("{email.notification.from.email}")
	private String fromEmail;

	private static final String XXXXXX = "XXXXXX";

	@Override
	public Future<Boolean> sendEmailNotification(Map<String, Object> map) {
		String templateName = getTemplateName(map);
		switch (templateName) {
		case "SIGN_UP_REQUEST_USER_AND_APPROVER_TEMPLATE":
			sendSignUpRequestDetailsToUser((SignUpRequest) map.get(templateName));
			break;
		case "SIGN_UP_REQUEST_USER_TEMPLATE": 
			sendSignUpRequestDetailsToUser((SignUpRequest) map.get(templateName));
			break;
		case "SIGN_UP_REQUEST_APPROVER_TEMPLATE":
			break;
		case "SIGN_UP_REQUEST_APPROVE_REJECT_TEMPLATE_FOR_USER":
			break;
		case "SIGN_UP_REQUEST_APPROVE_REJECT_TEMPLATE_FOR_APPROVER":
			break;

		}

		return null;
	}

	private boolean sendSignUpRequestDetailsToUser(SignUpRequest request) {
		EmailTemplate emailTemplate = emailTemplateRepository
				.findByName(EmailTemplateConstant.SIGN_UP_REQUEST_USER_TEMPLATE.getName());
		if (emailTemplate != null) {
			final String emailContent = mailContentBuilder.buildEmailContent(request,
					emailTemplate);
			if (emailContent != null) {
				boolean flag = false;
				MimeMessagePreparator messagePreparator = mimeMessage -> {
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

					messageHelper.setSubject(
							emailTemplate.getSubject().replace(XXXXXX, XXXXXX + request.getLoginRequestId()));
					messageHelper.setFrom(fromEmail);
					messageHelper.setTo(request.getUserName());
					messageHelper.setText(emailContent, true);
				};

				try {
					mailSender.send(messagePreparator);
					flag = true;
				} catch (MailException e) {
				}
				return flag;
			}
		}
		return false;

	}

	private String getTemplateName(Map<String, Object> map) {
		for (String k : map.keySet())
			return k;
		return null;

	}

}
