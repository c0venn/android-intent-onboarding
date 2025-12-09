import { WebPlugin } from '@capacitor/core';
import type { OnboardingPlugin, SendIntentParams, SendIntentResult } from './definitions';

export class OnboardingWeb extends WebPlugin implements OnboardingPlugin {
  async sendIntent(options: SendIntentParams): Promise<SendIntentResult> {
    console.log('Web sendIntent called with:', options);

    return {
      order_id: '',
      status_paid: '',
      estado: ''
    };
  }
}