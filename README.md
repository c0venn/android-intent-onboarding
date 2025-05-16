# android-intent-onboarding

android intent for onboarding

## Install

```bash
npm install android-intent-onboarding
npx cap sync
```

## API

<docgen-index>

* [`sendIntent(...)`](#sendintent)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### sendIntent(...)

```typescript
sendIntent(options: SendIntentParams) => Promise<SendIntentResult>
```

| Param         | Type                                                          |
| ------------- | ------------------------------------------------------------- |
| **`options`** | <code><a href="#sendintentparams">SendIntentParams</a></code> |

**Returns:** <code>Promise&lt;<a href="#sendintentresult">SendIntentResult</a>&gt;</code>

--------------------


### Interfaces


#### SendIntentResult

| Prop         | Type                |
| ------------ | ------------------- |
| **`estado`** | <code>number</code> |
| **`idpago`** | <code>number</code> |


#### SendIntentParams

| Prop         | Type                 |
| ------------ | -------------------- |
| **`monto`**  | <code>number</code>  |
| **`method`** | <code>string</code>  |
| **`tips`**   | <code>boolean</code> |

</docgen-api>
