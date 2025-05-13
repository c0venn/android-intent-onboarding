export interface onboardingPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
