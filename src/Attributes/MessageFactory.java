public static Message getMessage(String type) {
	switch (type) {
	case "Complaint":
		return new Complaint();
	case "WorkMessage":
		return new WorkMessage();
	case "Request":
		return new Request();
	default:
		throw new IllegalArgumentException("Message Type Uknown: " + type);
	}
}