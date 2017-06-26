package groupbyinc.events.components;

public class Visit {

    public static class CustomerData {
        private String visitorId, sessionId, loginId;

        public String getVisitorId() {
            return visitorId;
        }

        public CustomerData setVisitorId(String visitorId) {
            this.visitorId = visitorId;
            return this;
        }

        public String getSessionId() {
            return sessionId;
        }

        public CustomerData setSessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public String getLoginId() {
            return loginId;
        }

        public CustomerData setLoginId(String loginId) {
            this.loginId = loginId;
            return this;
        }


        public CustomerData(){
        }

        public CustomerData(String visitorId, String sessionId, String loginId){
            this.visitorId = visitorId;
            this.sessionId = sessionId;
            this.loginId = loginId;
        }
    }

    public static class Generated {
        // I don't think we actually need visitorCookieId or sessionCookieId or parsedUserAgent
        // Since we can probably save a 'deviceId' of some sorts? https://android-developers.googleblog.com/2011/03/identifying-app-installations.html
        // Though it is imperfect and probably not reliable
        private String visitorCookieId, sessionCookieId, userAgentString, parsedUserAgent, deviceType;

        // These are the things I think might be included?
        private String androidVersion, APIversion, brand, modelId, displaySize;

        public Generated(){
            // TODO get all things somehow

            // This code to get display size stuff seems broken
            // Probably because we're not importing android libraries
//            DisplayMetrics metrics = new DisplayMetrics();
//            getWindowManager().getDefaultDisplay().getMetrics(metrics);
//
//            int height = metrics.heightPixels;
//            int width = metrics.widthPixels;

        }

        // No setter since this should end up being some android library call
        // https://stackoverflow.com/questions/3213205/how-to-detect-system-information-like-os-or-device-type

    }

    CustomerData customerData;
    Generated generated;


}
