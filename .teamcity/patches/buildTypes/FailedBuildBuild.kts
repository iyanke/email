package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.notifications
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'FailedBuildBuild'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("FailedBuildBuild")) {
    check(name == "Failed build build") {
        "Unexpected name: '$name'"
    }
    name = "Failed build"

    features {
        remove {
            notifications {
                id = "BUILD_EXT_54"
                notifier = "email"
                brachFilter = "+:refs/heads/bbbb"
                buildStarted = true
                buildFailedToStart = true
                buildFailed = true
                firstFailureAfterSuccess = true
                newBuildProblemOccured = true
                buildFinishedSuccessfully = true
                firstBuildErrorOccurs = true
                buildProbablyHanging = true
                investigationUpdated = true
                muteUpdated = true
                param("email", "inna_yan@mail.ru")
            }
        }
    }

    cleanup {
        add {
            keepRule {
                id = "KEEP_RULE_12"
                keepAtLeast = allBuilds()
                applyToBuilds {
                    withTags = anyOf("tag")
                }
                dataToKeep = historyAndStatistics {
                    preserveArtifacts = all()
                }
                applyPerEachBranch = true
                preserveArtifactsDependencies = true
            }
        }
    }
}
