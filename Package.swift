// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "AndroidIntentOnboarding",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "AndroidIntentOnboarding",
            targets: ["onboardingPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "onboardingPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/onboardingPlugin"),
        .testTarget(
            name: "onboardingPluginTests",
            dependencies: ["onboardingPlugin"],
            path: "ios/Tests/onboardingPluginTests")
    ]
)