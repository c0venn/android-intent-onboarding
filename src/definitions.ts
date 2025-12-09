export interface SendIntentParams {
  orden_id: string;
  monto: number;
  st: string;
  channel: string;
  tipo: string;
}

export interface SendIntentResult {
  clientOrderId: string;
  clientStatus: string;
  estado: string;
}

export interface OnboardingPlugin {
  sendIntent(options: SendIntentParams): Promise<SendIntentResult>;
}