package tests.approvalCard.testSuit;

import tools.Config;

public class CS002 extends Config {

    //@Test //(/*invocationCount = 1, threadPoolSize = 1*/)
    /*public void testRun() {
        // step 1
        AuthPage authPage = open(baseUrl, AuthPage.class);
        ArmPage armPage = authPage.goAuth(authPage.getFortest1());
        armPage.userMenuName().shouldHave(innerText("Фортест1"));
        armPage.selectParentNode("Созданные мной документы");
        armPage.selectNode("Проекты");

        Awaitility
                .await()
                .pollInSameThread()
                .ignoreExceptions()
                .atMost(20, SECONDS)
                .until(() -> armPage.checkDocInTableAndStatus("У-503911-24"));
        *//*DocPage docPage = armPage.clickDocInTable("У-48119-24");
        String docNum =  docPage.getDocNumberText();
        authPage.outAuth();*//*
    }*/

}
