export interface OnboardingPlugin {
  startActivityForResult(options: {
    package: string;
    class: string;
    value: { [key: string]: any };
  }): Promise<{
    resultCode: number;
    extras: { [key: string]: any };
  }>;
}