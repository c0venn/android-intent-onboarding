import { registerPlugin } from '@capacitor/core';

import type { onboardingPlugin } from './definitions';

const onboarding = registerPlugin<onboardingPlugin>('onboarding', {
  web: () => import('./web').then((m) => new m.onboardingWeb()),
});

export * from './definitions';
export { onboarding };
