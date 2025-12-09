export interface SendIntentParams {
  orden_id: string;
  monto: number;
  st: string;
  channel: string;
  tipo: string;
}

export interface SendIntentResult {
  order_id: string;
  status_paid: string;
  estado: string;
}

export interface OnboardingPlugin {
  sendIntent(options: SendIntentParams): Promise<SendIntentResult>;
}