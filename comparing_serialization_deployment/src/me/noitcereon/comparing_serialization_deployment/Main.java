package me.noitcereon.comparing_serialization_deployment;

import me.noitcereon.comparing.ComparisonWorker;
import me.noitcereon.deployment.DeploymentWorker;
import me.noitcereon.serialization.SerializationWorker;

public class Main {
    public static void main(String[] args){
        ComparisonWorker.doComparisonWork(false);
        SerializationWorker.doSerializationWork(false);
        DeploymentWorker.main(new String[]{""});
    }
}
