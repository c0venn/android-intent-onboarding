import { WebPlugin } from '@capacitor/core';

import type { onboardingPlugin } from './definitions';

export class onboardingWeb extends WebPlugin implements onboardingPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
