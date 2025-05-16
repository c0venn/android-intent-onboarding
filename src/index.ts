import { registerPlugin } from '@capacitor/core';
import type { OnboardingPlugin } from './definitions';

const Onboarding = registerPlugin<OnboardingPlugin>('onboarding', {
  web: () => import('./web').then(m => new m.OnboardingWeb()),
});

export * from './definitions';
export { Onboarding };