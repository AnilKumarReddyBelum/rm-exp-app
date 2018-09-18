# rm-exp-app
Room Expense Manager web Application : Manages all the expenses in home or room or organization

Anil and I (Chandra) manage this project. We are developing this tool to track our monthly room expenses.

We are using the below technologies to develop this applicaiton.
<ul>
  <li>Spring Boot</li>
  <li>Spring MVC</li>
  <li>Spring REST</li>
  <li>JPA (Hibernate implemnetation)</li>
  <li>AngularJS</li>
  <li>Bootstrap</li>
</ul>
http://javasampleapproach.com/spring-framework/spring-cloud/configure-springboot-zuul-routing-filtering
https://github.com/adamzareba/company-structure-spring-security-oauth2-authorities


@DeleteMapping("/{uid}/assignRole/{rid}")
	void unAssignRole(@PathVariable("uid") Long uid, @PathVariable("rid") Long rid) throws Exception {
		User user = userService.findUserById(uid).orElseThrow(Exception::new);
		Role role = roleService.findRole(rid).orElseThrow(Exception::new);
		if (user.getRoles() != null && user.getRoles().stream().filter(r -> r.getId().equals(rid)).count() == 1) {
			user.getRoles().remove(role);
			userService.updateUser(user);
		} else {
			log.error("User does not contains this role with Id :: " + rid);
		}

	}
