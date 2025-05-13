import { registerPlugin } from '@capacitor/core';
import type { OnboardingPlugin } from './definitions';

const AndroidIntents = registerPlugin<OnboardingPlugin>('onboarding');

export * from './definitions';
export { AndroidIntents };