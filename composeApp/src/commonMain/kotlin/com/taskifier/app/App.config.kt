package com.taskifier.app;


val envId="d";
object AppConfig {
    val isDevEnv=envId.startsWith("d");
    val isTestEnv=envId.startsWith("t");
    val isProdEnv=envId.startsWith("p");

    val IP_ADDRESS=(
        if(isTestEnv) ""
        else if(isProdEnv) ""
        else ""
    );
}