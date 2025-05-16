export interface SendIntentParams {
  monto: number;
  method: string;
  tips: boolean;
}

export interface SendIntentResult {
  estado: number;
  idpago: number;
}

export interface OnboardingPlugin {
  sendIntent(options: SendIntentParams): Promise<SendIntentResult>;
}